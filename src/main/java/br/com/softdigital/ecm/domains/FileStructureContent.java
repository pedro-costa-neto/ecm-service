package br.com.softdigital.ecm.domains;

public class FileStructureContent extends FileStructureDecorator {

	public FileStructureContent() {
		this.documentType = 2;
	}
	
	@Override
	public Integer getDocumentType() {
		return this.documentType;
	}

}
