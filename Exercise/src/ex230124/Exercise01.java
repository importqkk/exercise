package ex230124;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class Exercise01 {
	public static void main(String[] args) {
		
		// System.currentTimeMillis()
		long a = System.currentTimeMillis();
		System.out.println("a: " + a);
		
		Format format = new SimpleDateFormat("yyyy-MM-dd / a hh:mm:ss.SSS");
		System.out.println("a(format): " + format.format(a));
		
		
		// java.util.Date
		Date b = new Date();
		System.out.println("b: " + b);
		
		Date c = new Date(2024, 6, 30);
		System.out.println("c: " + c);
		
		
		// java.util.Calendar
		Calendar d = Calendar.getInstance();
		System.out.println("d(Calendar): " + d);
		
		int year = d.get(Calendar.YEAR);
		System.out.println("year: " + year);
		
		int month = d.get(Calendar.MONTH) + 1;
		System.out.println("month: " + month);
		
		int day = d.get(Calendar.DAY_OF_MONTH);
		System.out.println("day: " + day);
		
		Date dDate = d.getTime();
		System.out.println("dDate: " + format.format(dDate));
		
		d.set(2024, 6, 30, 12, 30, 30);
		System.out.println("d(set): " + d.getTime());
		
		d.add(Calendar.DAY_OF_MONTH, 23);
		System.out.println("d(add): " + d.getTime());
		
		
		// java.time
		LocalTime e = LocalTime.now();
		System.out.println("e: " + e);
		System.out.println("LocalTime hour: " + e.getHour());
		System.out.println("LocalTime minute: " + e.getMinute());
		System.out.println("LocalTime second: " + e.getSecond());
		System.out.println("LocalTIme nano second: " + e.getNano());
		
		LocalDate f = LocalDate.now();
		System.out.println("f: " + f);
		System.out.println("LocalDate year: " + f.getYear());
		System.out.println("LocalDate month: " + f.getMonthValue());
		System.out.println("LocalDate day: " + f.getDayOfMonth());
		System.out.println("LocalDatd day of week: " + f.getDayOfWeek());
		
		LocalDate g = LocalDate.of(2024, 6, 30);
		System.out.println("g: " + g);
		
		LocalDateTime h = LocalDateTime.now();
		System.out.println("h: " + h);
		
		Period period = Period.between(f, g);
		System.out.println("period: " + period);
		System.out.println("period year: " + period.getYears());
		System.out.println("period month: " + period.getMonths());
		System.out.println("period day: " + period.getDays());
		
	}
}
