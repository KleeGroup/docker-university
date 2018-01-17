<%@ page import="java.net.InetAddress" %>
<%@ page import="java.net.Inet4Address" %>
<%@ page import="java.net.NetworkInterface" %>
<%@ page import="java.util.Enumeration" %>

<%
	String host = "";
	NetworkInterface iface = null;
	for(Enumeration<NetworkInterface> ifaces = NetworkInterface.getNetworkInterfaces();ifaces.hasMoreElements();){
		iface = (NetworkInterface) ifaces.nextElement();
		InetAddress ia = null;
		for (Enumeration<InetAddress> ips = iface.getInetAddresses(); ips.hasMoreElements();) {
			ia = (InetAddress) ips.nextElement();
			if (!ia.isLoopbackAddress() && (!ia.isLinkLocalAddress()) && (ia instanceof Inet4Address))
				host = ia.getHostName();
		}
	}
%>
<html>
  <body>
    <h2>Hello World!</h2>
    <p>Hostname : <%=host %></p>
  </body>
</html>

