package m2m.service;

import java.util.Random;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ObjectFactoryCreatingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import m2m.dto.Sensor;

@Service
public class SensorGenerator
{
	int seqNumber = 1;
	ObjectMapper mapper = new ObjectMapper();
	Random random = new Random();
	
	@Value("${n_sensor:10}")
	private int nSensor;
	
	@Value("${min_value:50}")
	private int minValue;
	
	@Value("${max_value:250}")
	private int maxValue;
	
	@Bean
	public Supplier<String> sendSensorData()
	{
		return () ->
		{
			Sensor sensor = getRandomSensor();
			try
			{
				return mapper.writeValueAsString(sensor);
			} catch (JsonProcessingException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		};
	}

	private Sensor getRandomSensor()
	{
		int id = getRandomNumber(1, nSensor);
		int value = getRandomNumber(minValue, maxValue);
		long timestamp = System.currentTimeMillis();
		Sensor sensor = new Sensor(timestamp, seqNumber, id, value);
		seqNumber++;
		return sensor;
	}

	private int getRandomNumber(int min, int max)
	{
		return random.ints(1, min, max+1).findFirst().getAsInt();
	}
}
