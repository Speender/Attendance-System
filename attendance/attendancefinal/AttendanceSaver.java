package attendance.attendancefinal;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JTable;

public class AttendanceSaver {

    public void saveTableToFile(JTable table) {
        LocalDate currentDate = LocalDate.now();
        String formattedDate = currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String fileName = formattedDate + "_Attendance.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            int[] columnWidths = new int[table.getColumnCount()];

            for (int col = 0; col < table.getColumnCount(); col++) {
                columnWidths[col] = table.getColumnName(col).length(); 
                for (int row = 0; row < table.getRowCount(); row++) {
                    Object value = table.getValueAt(row, col);
                    if (value != null) {
                        columnWidths[col] = Math.max(columnWidths[col], value.toString().length());
                    }
                }
            }

            for (int col = 0; col < table.getColumnCount(); col++) {
                writer.write(String.format("%-" + (columnWidths[col] + 2) + "s", table.getColumnName(col)));
            }
            writer.newLine();

            for (int row = 0; row < table.getRowCount(); row++) {
                for (int col = 0; col < table.getColumnCount(); col++) {
                    Object value = table.getValueAt(row, col);
                    writer.write(String.format("%-" + (columnWidths[col] + 2) + "s", value == null ? "" : value.toString()));
                }
                writer.newLine();
            }

            writer.flush();
            System.out.println("Attendance saved to: " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving file: " + e.getMessage());
        }
    }
}
