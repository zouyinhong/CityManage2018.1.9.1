package mycity.com.citymanage.entity;

/**
 * class EntityGongGao
 * <p/>
 * Created by Kyle on 2017/4/8.
 */
public class EntityGongGao {

    String title;
    String content;
    String imagesList;
    String endDate;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImagesList() {
        return imagesList;
    }

    public void setImagesList(String imagesList) {
        this.imagesList = imagesList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "EntityGongGao{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", imagesList='" + imagesList + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
