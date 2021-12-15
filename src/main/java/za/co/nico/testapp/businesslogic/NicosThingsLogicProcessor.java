package za.co.nico.testapp.businesslogic;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import za.co.nico.testapp.dtos.NicosThingRequest;
import za.co.nico.testapp.model.NicosThing;
import za.co.nico.testapp.repositories.NicosThingsRepository;
import za.co.nico.testapp.utils.RequestResponseUtils;

@Component
public class NicosThingsLogicProcessor {
	private static final Logger log = LoggerFactory.getLogger(NicosThingsLogicProcessor.class);
	
	@Autowired
	NicosThingsRepository nicoRep;



	public List<NicosThing> listAllNicosThingsSortedByName() {
		return nicoRep.findAll(sortByNameAsc());
	}

	public NicosThingRequest newNicosThing() {
		NicosThingRequest request =new NicosThingRequest();
		Timestamp dateCreated =new Timestamp(new Date().getTime());
		request.setDateCreated(dateCreated);
		return request;
	}
	

	public List<NicosThing> save(NicosThingRequest request) {
		NicosThing nicosThings=RequestResponseUtils.makeNicosThing(request);
		nicosThings=nicoRep.save(nicosThings);
		return listAllNicosThingsSortedByName();
	}
	

	public List<NicosThing> update(NicosThingRequest request) {
		if(request!=null) {
			Long nicosThingId=request.getNicosThingId();
			if(nicosThingId!=null) {
				NicosThing nicosThing =nicoRep.findByNicosThingId(nicosThingId);
				nicosThing=RequestResponseUtils.updateNicosThing(nicosThing,request);
				nicosThing=nicoRep.save(nicosThing);
			}
		}
		
		return listAllNicosThingsSortedByName();
	}
	
	public NicosThingRequest verander(Long nicosThingId) {
		NicosThing nicosThing =nicoRep.findByNicosThingId(nicosThingId);
		NicosThingRequest request = RequestResponseUtils.makeNicosThingRequest(nicosThing);
		return request;
	}


	public void deleteNicosThings(Long nicosThingsId) {	
		nicoRep.deleteById(nicosThingsId);
	}

//	private NicosThing findNicosThingsByNicosThingsId(Long nicosThingId) {
//		return nicoRep.findByNicosThingId(nicosThingId);
//	}

//	private NicosThing saveNicosThings(NicosThingRequest request) {
//		NicosThing nicosThings=RequestResponseUtils.makeNicosThing(request);
//		nicosThings=nicoRep.save(nicosThings);
//		return nicosThings;
//	}
	
	
	private Sort sortByDateCreatedAsc() {
        return new Sort(Sort.Direction.ASC, "dateCreated");
    }
	
	private Sort sortByDateCreatedDesc() {
        return new Sort(Sort.Direction.DESC, "dateCreated");
    }

	private Sort sortByNameAsc() {
        return new Sort(Sort.Direction.ASC, "name");
    }











}
