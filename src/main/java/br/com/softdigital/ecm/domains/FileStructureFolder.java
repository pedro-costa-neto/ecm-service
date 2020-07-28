package br.com.softdigital.ecm.domains;

public class FileStructureFolder extends FileStructureDecorator{

	public FileStructureFolder() {
		this.documentType = 0;
	}
	
	@Override
	public Integer getDocumentType() {
		return this.documentType;
	}

}
