package br.com.softdigital.ecm.domains;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("file_structure_version")
public class FileStructureVersion extends FileStructureDecorator {
	private static final long serialVersionUID = 1L;
	
	@DBRef
	private FileStructureDecorator mainId;
	
	@Override
	public Integer getDocumentType() {
		return this.documentType;
	}
	
	public void setDocumentType(Integer documentType) {
		this.documentType = documentType;
	}

	public FileStructureDecorator getMainId() {
		return mainId;
	}

	public void setMainId(FileStructureDecorator mainId) {
		this.mainId = mainId;
	}
	
}
