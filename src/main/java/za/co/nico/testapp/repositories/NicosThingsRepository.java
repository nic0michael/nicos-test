package za.co.nico.testapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.nico.testapp.model.NicosThing;

public interface NicosThingsRepository extends JpaRepository<NicosThing, Long> {

	public NicosThing findByNicosThingId(Long nicosThingId);

}
