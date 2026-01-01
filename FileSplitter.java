import java.io.*;

public class FileSplitter {

    public static void main(String[] args) {

        // Validasi argument
        if (args.length < 2) {
            System.out.println("java FileSplitter ninaaa_file 3");
            return;
        }

        String fileName = args[0];
        int linesPerPart = Integer.parseInt(args[1]);

        TextQueue queue = new TextQueue();

        // Membaca file dan memasukkan ke Queue
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                queue.enqueue(line);
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca file!");
            return;
        }

        // Proses pemotongan file menggunakan Queue
        int partNumber = 1;

        while (!queue.isEmpty()) {
            try (BufferedWriter writer = new BufferedWriter(
                    new FileWriter("output_part_" + partNumber + ".txt"))) {

                for (int i = 0; i < linesPerPart && !queue.isEmpty(); i++) {
                    writer.write(queue.dequeue());
                    writer.newLine();
                }

                System.out.println("output_part_" + partNumber + ".txt berhasil dibuat");
                partNumber++;

            } catch (IOException e) {
                System.out.println("Gagal menulis file output!");
            }
        }
    }
}
