package com.openclassrooms.safetynet.model;

/**
 * Firestations Model
 * @author Silvio
 *
 */

public class Firestations
{
	private String address;
	private String station;
	
	
	
	public Firestations()
	{
		
	}


	public Firestations(String address, String station)
	{
		super();
		this.address = address;
		this.station = station;
	}


	@Override
	public String toString()
	{
		return "[address=" + address + ", station=" + station + "]";
	}
	
	
	// GETTERS SETTERS
	
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public String getStation()
	{
		return station;
	}
	public void setStation(String station)
	{
		this.station = station;
	}
	
	
}
