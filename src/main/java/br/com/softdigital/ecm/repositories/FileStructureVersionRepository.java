package br.com.softdigital.ecm.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.softdigital.ecm.domains.FileStructureVersion;
import br.com.softdigital.ecm.dto.FileStructureSimpleDto;

public interface FileStructureVersionRepository extends MongoRepository<FileStructureVersion, String>{

	List<FileStructureSimpleDto> findByMainId(String mainId);
}
