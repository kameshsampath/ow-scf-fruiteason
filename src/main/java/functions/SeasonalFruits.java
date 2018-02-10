package functions;

/**
 * SeasonalFruits
 */
public class SeasonalFruits {

  private String season;
  private String[] fruits;

  public SeasonalFruits() {

  }

  public SeasonalFruits(String season, String[] fruits) {
    this.season = season;
    this.fruits = fruits;
  }

  /**
   * @return the fruits
   */
  public String[] getFruits() {
    return fruits;
  }

  /**
   * @param fruits the fruits to set
   */
  public void setFruits(String[] fruits) {
    this.fruits = fruits;
  }

  /**
   * @return the season
   */
  public String getSeason() {
    return season;
  }

  /**
   * @param season the season to set
   */
  public void setSeason(String season) {
    this.season = season;
  }
}
