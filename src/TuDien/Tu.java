package TuDien;

public class Tu {
	private String tienganh;
	private String tuloai;
	private String tiengviet;
	
	public Tu() {
		this.tienganh = new String();
		this.tuloai = new String();
		this.tiengviet = new String();
	}
	
	public Tu(String tienganh, String tuloai, String tiengviet) {
		this.tienganh = new String(tienganh);
		this.tuloai = new String(tuloai);
		this.tiengviet = new String(tiengviet);
	}
	
	public Tu(Tu w) {
		this.tienganh = new String(w.layTiengAnh());
		this.tuloai = new String(w.layTuLoai());
		this.tiengviet = new String(w.layTiengViet());
	}
	
	public String layTiengAnh() {
		return this.tienganh;
	}
	
	public String layTuLoai() {
		return this.tuloai;
	}
	
	public String layTiengViet() {
		return this.tiengviet;
	}
	
	public void thayDoiTuLoai(String st) {
		this.tuloai = st;
	}
	
	public void thayDoiTiengViet(String st) {
		this.tiengviet = st;
	}
}
