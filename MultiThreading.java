import java.io.FileReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MultiThreading {

    private static final Logger LOGGER = Logger.getLogger(MultiThreading.class.getName());
    private static final int NUM_THREADS = Runtime.getRuntime().availableProcessors();

    @Override
    public List<?> readFromCsv(String filePath) {
        try (ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS)) {
            List<Future<List<?>>> futures = new ArrayList<>();

            try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
                String[] header = reader.readNext();
                if (header == null) {
                    return Collections.emptyList();
                }

                List<String[]> lines = new ArrayList<>();
                String[] line;
                while ((line = reader.readNext()) != null) {
                    lines.add(line);
                }

                int chunkSize = (int) Math.ceil((double) lines.size() / NUM_THREADS);
                for (int i = 0; i < NUM_THREADS; i++) {
                    int start = i * chunkSize;
                    int end = Math.min(start + chunkSize, lines.size());
                    List<String[]> chunk = lines.subList(start, end);
                    futures.add(executor.submit(new CsvChunkProcessor(header, chunk)));
                }

                List<?> result = new ArrayList<>();
                for (Future<List<?>> future : futures) {
                    result.addAll(future.get());
                }
                return result;
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Error reading CSV file: " + filePath, e);
                return Collections.emptyList();
            } finally {
                executor.shutdown();
            }
        }
    }

    private record CsvChunkProcessor(String[] header, List<String[]> chunk) implements Callable<List<?>> {
        @Override
        public List<?> call() {
            try {
                CsvToBean<?> csvToBean = new CsvToBeanBuilder<?>(new StringReader(convertChunkToString()))
                        .withType(?.class)
                        .build();
                return csvToBean.parse();
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Error processing CSV chunk", e);
                return Collections.emptyList();
            }
        }

        private String convertChunkToString() {
            StringBuilder sb = new StringBuilder();
            for (String value : header) {
                sb.append(value).append(",");
            }
            sb.setLength(sb.length() - 1); // Remove trailing comma
            sb.append("\n");
            for (String[] line : chunk) {
                for (String value : line) {
                    sb.append(value).append(",");
                }
                sb.setLength(sb.length() - 1); // Remove trailing comma
                sb.append("\n");
            }
            return sb.toString();
        }
    }
}
