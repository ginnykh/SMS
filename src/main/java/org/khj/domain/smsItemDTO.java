package org.khj.domain;

public class smsItemDTO {

	private int ino;
	private String dfw;
	private String name;
	private String contents;
	private String url;
	private String mem;
	private String itemfor;
	private String size;
	private String fileName;
	private String uploadPath;
	private String uuid;
	private boolean image;

	public String getDfw() {
		return dfw;
	}
	public void setDfw(String dfw) {
		this.dfw = dfw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMem() {
		return mem;
	}
	public void setMem(String mem) {
		this.mem = mem;
	}
	public String getItemfor() {
		return itemfor;
	}
	public void setItemfor(String itemfor) {
		this.itemfor = itemfor;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
	public int getIno() {
		return ino;
	}
	public void setIno(int ino) {
		this.ino = ino;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUploadPath() {
		return uploadPath;
	}
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public boolean isImage() {
		return image;
	}
	public void setImage(boolean image) {
		this.image = image;
	}
	
	@Override
	public String toString() {
		return "smsItemDTO [ino=" + ino + ", dfw=" + dfw + ", name=" + name + ", contents=" + contents + ", url=" + url
				+ ", mem=" + mem + ", itemfor=" + itemfor + ", size=" + size + ", fileName=" + fileName
				+ ", uploadPath=" + uploadPath + ", uuid=" + uuid + ", image=" + image + "]";
	}
	
}
