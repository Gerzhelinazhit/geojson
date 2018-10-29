package app.parser;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


import java.util.ArrayList;
import java.util.List;

public class JsonModel {
    class GeoJson {
        @SerializedName("type")
        @Expose
        public String type;
        @SerializedName("features")
        @Expose
        public List<Features> features = new ArrayList<Features>();

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<Features> getFeatures() {
            return features;
        }

        public void setFeatures(List<Features> features) {
            this.features = features;
        }
    }


    class Features {
        @SerializedName("type")
        @Expose
        public String type;
        @SerializedName("geometry")
        @Expose
        public Geometry geometry;
        @SerializedName("properties")
        @Expose
        public Properties properties;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Geometry getGeometry() {
            return geometry;
        }

        public void setGeometry(Geometry geometry) {
            this.geometry = geometry;
        }

        public Properties getProperties() {
            return properties;
        }

        public void setProperties(Properties properties) {
            this.properties = properties;
        }
    }


    class Geometry {
        @SerializedName("type")
        @Expose
        public String type;
//        @SerializedName("coordinates")
        /*@Expose
        public List<Coordinates> coordinates = new ArrayList<Coordinates>();
*/
        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }


    }



    class Properties {
        @SerializedName("stroke")
        @Expose
        public String stroke;
        @SerializedName("stroke-width")
        @Expose
        public double strokeWidth;
        @SerializedName("stroke-opacity")
        @Expose
        public double strokeOpasity;
        @SerializedName("fill")
        @Expose
        public String fill;
        @SerializedName("fill-opacity")
        @Expose
        public double fillOpacity;
        @SerializedName("ID")
        @Expose
        public String id;
        @SerializedName("levelID")
        @Expose
        public int levelId;
        @SerializedName("parentID")
        @Expose
        public String parentId;
        @SerializedName("pathID")
        @Expose
        public String pathId;

        public String getStroke() {
            return stroke;
        }

        public void setStroke(String stroke) {
            this.stroke = stroke;
        }

        public double getStrokeWidth() {
            return strokeWidth;
        }

        public void setStrokeWidth(double strokeWidth) {
            this.strokeWidth = strokeWidth;
        }

        public double getStrokeOpasity() {
            return strokeOpasity;
        }

        public void setStrokeOpasity(double strokeOpasity) {
            this.strokeOpasity = strokeOpasity;
        }

        public String getFill() {
            return fill;
        }

        public void setFill(String fill) {
            this.fill = fill;
        }

        public double getFillOpacity() {
            return fillOpacity;
        }

        public void setFillOpacity(double fillOpacity) {
            this.fillOpacity = fillOpacity;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getLevelId() {
            return levelId;
        }

        public void setLevelId(int levelId) {
            this.levelId = levelId;
        }

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }

        public String getPathId() {
            return pathId;
        }

        public void setPathId(String pathId) {
            this.pathId = pathId;
        }
    }
}