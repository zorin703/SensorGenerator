package m2m;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SensorAppl
{
	private static final long TIMEOUT = 30000;

	public static void main(String[] args) throws InterruptedException
	{
		ConfigurableApplicationContext cac = SpringApplication.run(SensorAppl.class, args);
		Thread.sleep(TIMEOUT);
		cac.close();
	}

}
