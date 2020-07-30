package br.com.softdigital.ecm.domains;

public class FileStructureFolder extends FileStructureDecorator{
	private static final long serialVersionUID = 1L;

	public FileStructureFolder() {
		this.documentType = 0;
	}
	
	@Override
	public Integer getDocumentType() {
		return this.documentType;
	}

}
