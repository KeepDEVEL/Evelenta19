package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите дату в формате dd.MM.yyyy: ");
        String inputDate1 = scanner.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date1 = null;
        try {
            date1 = dateFormat.parse(inputDate1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);
        calendar1.add(Calendar.DAY_OF_YEAR, 45);
        Date increasedDate1 = calendar1.getTime();

        System.out.println("Увеличенная дата: " + dateFormat.format(increasedDate1));

        Calendar yearStart = Calendar.getInstance();
        yearStart.setTime(date1);
        yearStart.set(Calendar.DAY_OF_YEAR, 1);
        Date yearStartDate = yearStart.getTime();

        System.out.println("Дата начала года: " + dateFormat.format(yearStartDate));

        Calendar workingDays = Calendar.getInstance();
        workingDays.setTime(date1);
        int daysCount = 0;
        while (daysCount < 10) {
            workingDays.add(Calendar.DAY_OF_YEAR, 1);
            int dayOfWeek = workingDays.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
                daysCount++;
            }
        }
        Date increasedWorkingDays = workingDays.getTime();

        System.out.println("Увеличенная дата на 10 рабочих дней: " + dateFormat.format(increasedWorkingDays));

        System.out.print("Введите вторую дату в формате dd.MM.yyyy: ");
        String inputDate2 = scanner.nextLine();

        Date date2 = null;
        try {
            date2 = dateFormat.parse(inputDate2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar start = Calendar.getInstance();
        start.setTime(date1);
        Calendar end = Calendar.getInstance();
        end.setTime(date2);
        int workDaysCount = 0;
        while (!start.after(end)) {
            int dayOfWeek = start.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
                workDaysCount++;
            }
            start.add(Calendar.DAY_OF_YEAR, 1);
        }

        System.out.println("Количество рабочих дней между двумя датами: " + workDaysCount);

        scanner.close();
    }
}