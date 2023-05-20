/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logbook.report;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Adisa
 */
public class HelperMain {

    public static File makeDirectory(String directory) {
        return new File(System.getProperty("user.home") + directory);
    }

    public static void copyFile(String sourcePath, String destinationPath) {
        try {
            InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream(sourcePath);
            Files.copy(inputStream, Paths.get(destinationPath), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String leftPad(String input, int length, String padStr) {
        if (input == null || padStr == null) {
            return null;
        }

        if (input.length() >= length) {
            return input;
        }

        int padLength = length - input.length();

        StringBuilder paddedString = new StringBuilder();
        paddedString.append(padStr.repeat(padLength));
        paddedString.append(input);

        return paddedString.toString();
    }

    public static String formatTanggal(Date date) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.format(date);
        } catch (Exception e) {
            return null;
        }
    }

    public static String formatTanggalCetak(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        String day = new SimpleDateFormat("EEE").format(date);

        String hari = formatHari(day);
        int tanggal = calendar.get(Calendar.DATE);
        String bulan = formatBulan(calendar.get(Calendar.MONTH));
        int tahun = calendar.get(Calendar.YEAR);

        return hari + " " + tanggal + " " + bulan + " " + tahun;
    }

    public static String formatHari(String day) {
        switch (day) {
            case "Mon":
                return "Senin";
            case "Tue":
                return "Selasa";
            case "Wed":
                return "Rabu";
            case "Thu":
                return "Kamis";
            case "Fri":
                return "Jum'at";
            case "Sat":
                return "Sabtu";
            case "Sun":
                return "Minggu";
            default:
                return "";
        }
    }

    public static String formatBulan(int month) {
        String[] strBulan = new String[]{
            "Januari",
            "Februari",
            "Maret",
            "April",
            "Mei",
            "Juni",
            "Juli",
            "Agustus",
            "September",
            "Oktober",
            "November",
            "Desember"
        };
        return strBulan[month];
    }
}
