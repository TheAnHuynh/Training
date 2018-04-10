package d14cqcp01.group5.tigia;

public class TiGia {
    private Float giaVang9999, giaVang24k, giaUSD;

    public TiGia() {
    }

    public TiGia(Float giaVang9999, Float giaVang24k, Float giaUSD) {
        this.giaVang9999 = giaVang9999;
        this.giaVang24k = giaVang24k;
        this.giaUSD = giaUSD;
    }

    public Float getGiaVang9999() {
        return giaVang9999;
    }

    public void setGiaVang9999(Float giaVang9999) {
        this.giaVang9999 = giaVang9999;
    }

    public Float getGiaVang24k() {
        return giaVang24k;
    }

    public void setGiaVang24k(Float giaVang24k) {
        this.giaVang24k = giaVang24k;
    }

    public Float getGiaUSD() {
        return giaUSD;
    }

    public void setGiaUSD(Float giaUSD) {
        this.giaUSD = giaUSD;
    }

    @Override
    public String toString() {
        return "Giá Vàng 9999:" + getGiaVang9999() + "\n"
                +"Giá Vàng 24K:" + getGiaVang24k() + "\n"
                +"Giá USD:" + getGiaUSD();
    }
}
