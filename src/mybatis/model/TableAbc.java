package mybatis.model;

public class TableAbc {
    private Integer id;

    private String aaa;

    private String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAaa() {
        return aaa;
    }

    public void setAaa(String aaa) {
        this.aaa = aaa;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "TableAbc{" +
                "id=" + id +
                ", aaa='" + aaa + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}