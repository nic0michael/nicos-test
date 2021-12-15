package za.co.nico.testapp.utils;

import za.co.nico.testapp.dtos.NicosThingRequest;
import za.co.nico.testapp.model.NicosThing;

public class RequestResponseUtils {

	public static NicosThing makeNicosThing(NicosThingRequest request) {
		NicosThing nicosThing =new NicosThing();
		return updateNicosThing(nicosThing, request);
	}


	public static NicosThing updateNicosThing(NicosThing nicosThing,NicosThingRequest request) {
		if(request!=null && nicosThing!=null) {
			nicosThing.setCellPhone(request.getCellPhone());
			nicosThing.setDateCreated(request.getDateCreated());
			nicosThing.setEmailAddress(request.getEmailAddress());
			nicosThing.setName(request.getName());
		}
		return nicosThing;
	}


	public static NicosThingRequest makeNicosThingRequest(NicosThing nicosThing) {
		NicosThingRequest request=new NicosThingRequest();
		if(nicosThing!=null) {
			request.setNicosThingId(nicosThing.getNicosThingId());
			request.setCellPhone(nicosThing.getCellPhone());
			request.setDateCreated(nicosThing.getDateCreated());
			request.setEmailAddress(nicosThing.getEmailAddress());
			request.setName(nicosThing.getName());
			
		}
		return request;
	}




	

	



}
