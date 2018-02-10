package functions;

import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FruiteasonApplication {

  @Bean
  public Function<SeasonalFruits, SeasonalFruits> fruiteason() {

    return season -> {
      if (season != null) {
        switch (season.getSeason().toLowerCase()) {
        case "summer": {
          return new SeasonalFruits("summer",
              new String[] { "Apricots", "Grapes", "Peaches", "Figs", "Watermelon", "Jackfruit" });
        }
        case "fall": {
          return new SeasonalFruits("fall",
              new String[] { "Pineapple", "Pomegranate", "Pear", "Guava", "Cape Gooseberries", "Cranberries" });
        }
        case "winter": {
          return new SeasonalFruits("winter",
              new String[] { "Grapefruit", "Dates", "Pear", " Kiwifruit", "Oranges", "Red Banana" });
        }
        case "spring": {
          return new SeasonalFruits("spring",
              new String[] { "Apricots", "Apricots", " Mango", "Lychee", "Honeydew", "Jackfruit" });
        }
        default: {
          return new SeasonalFruits("all",
              new String[] { "Apples", "Avocados", " Bananas", "Coconut", "Lemons", "Papayas" });
        }
        }
      }
      return new SeasonalFruits("all",
          new String[] { "Apples", "Avocados", " Bananas", "Coconut", "Lemons", "Papayas" });
    };

  }

  public static void main(String[] args) {
    SpringApplication.run(FruiteasonApplication.class, args);
  }

}
