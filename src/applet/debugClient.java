package applet;

public class debugClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JSApplet t = new JSApplet();
		
		String inputSoap = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:SOAP-ENC=\"http://schemas.xmlsoap.org/soap/encoding\" xmlns:xsd=\"http://www.w3.org/1999/XMLSchema\" xmlns:xsi=\"http://www.w3.org/1999/XMLSchema-instance\" encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\"><Body><ICCE.identificaCittadinoEsteso xmlns:m=\"http://www.crs.lombardia.it/schemas/DCSanita/ICCE/2008-01/identificaCittadinoEsteso/\" dataSetVersion=\"1.0\"><param><profiloCittadino><idAssistito /><cognome /><nome /><codiceFiscale>CTTSTT76A01F205G</codiceFiscale><dataNascita /><idLocalitaNascita /><codiceSesso /><omettiEsenzioni /></profiloCittadino><attributiRicerca><pageNumber>2</pageNumber><useWildcard /><maxRecords>20</maxRecords></attributiRicerca></param></ICCE.identificaCittadinoEsteso></Body></Envelope>";
		String res = t.sendSoapToSebContainer(inputSoap);
		System.out.println(res);
	}

}
