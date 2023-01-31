package ex230131.utils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcUtils {
	
	public static final String DRIVER = "oracle.jdbc.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USERNAME = "kh11";
	public static final String PASSWORD = "kh11";
	
	public static DriverManagerDataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(DRIVER);
		dataSource.setUrl(URL);
		dataSource.setUsername(USERNAME);
		dataSource.setPassword(PASSWORD);
		return dataSource;
	}
	
	public static JdbcTemplate getjdJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
	
}
