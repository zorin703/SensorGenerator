package m2m.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Sensor
{
	public long timestamp;
	public int seqNumber;
	public int id;
	public int value;
}
