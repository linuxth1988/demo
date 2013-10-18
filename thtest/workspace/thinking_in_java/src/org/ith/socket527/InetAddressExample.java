package org.ith.socket527;
import java.net.*;
import java.util.Enumeration;
public class InetAddressExample
{
	public static void main(String[] args)
	{
		//get the network interfaces and associate address for the host
		try
		{
			Enumeration<NetworkInterface> interfaceList = NetworkInterface.getNetworkInterfaces();
			
			if(interfaceList == null)
			{
				System.out.println("--No interfaces found--");
			}
			else
			{
				while(interfaceList.hasMoreElements())
				{
					NetworkInterface iface = interfaceList.nextElement();
				
					System.out.println("Interface " + iface.getName());
				
					Enumeration<InetAddress> addrList = iface.getInetAddresses();
					
					if(!addrList.hasMoreElements())
					{
						System.out.println("\t(No address for the interface");
					}
					
					while(addrList.hasMoreElements())
					{
						InetAddress address = addrList.nextElement();
						System.out.println(":::"+address.getCanonicalHostName());
					}
				}
			}
			
			System.out.println("-----------------------------------------------------");
			
			
			InetAddress[] ids = InetAddress.getAllByName("www.ebay.com");
			for(InetAddress id : ids)
				System.out.println(id.getHostAddress()+"====="+id.toString());
			
		
		}catch(Exception e)
		{
			System.out.println("Error getting network interfaces: "+e.getMessage());
		}
	}
}
