package byr.win.planthelper.domain;

public class CategoryInfo {
    private Integer categoryId;

    private String categoryName;

    private Integer difficulty;

    private String behavior;

    private String trait;

    private String kingdomC;

    private String phylumC;

    private String classC;

    private String orderC;

    private String familyC;

    private String genusC;

    private String speciesC;

    private Float tempLowBound;

    private Float tempHighBound;

    private Float humiLowBound;

    private Float humiHighBound;

    private Float illumLowBound;

    private Float illumHighBound;

    private Integer location;

    private Integer artistic;

    private Integer season;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior == null ? null : behavior.trim();
    }

    public String getTrait() {
        return trait;
    }

    public void setTrait(String trait) {
        this.trait = trait == null ? null : trait.trim();
    }

    public String getKingdomC() {
        return kingdomC;
    }

    public void setKingdomC(String kingdomC) {
        this.kingdomC = kingdomC == null ? null : kingdomC.trim();
    }

    public String getPhylumC() {
        return phylumC;
    }

    public void setPhylumC(String phylumC) {
        this.phylumC = phylumC == null ? null : phylumC.trim();
    }

    public String getClassC() {
        return classC;
    }

    public void setClassC(String classC) {
        this.classC = classC == null ? null : classC.trim();
    }

    public String getOrderC() {
        return orderC;
    }

    public void setOrderC(String orderC) {
        this.orderC = orderC == null ? null : orderC.trim();
    }

    public String getFamilyC() {
        return familyC;
    }

    public void setFamilyC(String familyC) {
        this.familyC = familyC == null ? null : familyC.trim();
    }

    public String getGenusC() {
        return genusC;
    }

    public void setGenusC(String genusC) {
        this.genusC = genusC == null ? null : genusC.trim();
    }

    public String getSpeciesC() {
        return speciesC;
    }

    public void setSpeciesC(String speciesC) {
        this.speciesC = speciesC == null ? null : speciesC.trim();
    }

    public Float getTempLowBound() {
        return tempLowBound;
    }

    public void setTempLowBound(Float tempLowBound) {
        this.tempLowBound = tempLowBound;
    }

    public Float getTempHighBound() {
        return tempHighBound;
    }

    public void setTempHighBound(Float tempHighBound) {
        this.tempHighBound = tempHighBound;
    }

    public Float getHumiLowBound() {
        return humiLowBound;
    }

    public void setHumiLowBound(Float humiLowBound) {
        this.humiLowBound = humiLowBound;
    }

    public Float getHumiHighBound() {
        return humiHighBound;
    }

    public void setHumiHighBound(Float humiHighBound) {
        this.humiHighBound = humiHighBound;
    }

    public Float getIllumLowBound() {
        return illumLowBound;
    }

    public void setIllumLowBound(Float illumLowBound) {
        this.illumLowBound = illumLowBound;
    }

    public Float getIllumHighBound() {
        return illumHighBound;
    }

    public void setIllumHighBound(Float illumHighBound) {
        this.illumHighBound = illumHighBound;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public Integer getArtistic() {
        return artistic;
    }

    public void setArtistic(Integer artistic) {
        this.artistic = artistic;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }
}