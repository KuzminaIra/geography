package geography;

import geography.Entities.CityEntity;
import geography.Entities.CountryEntity;
import geography.Entities.RegionEntity;
import geography.Repositories.CityRepository;
import geography.Repositories.CountryRepository;
import geography.Repositories.RegionRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class Starter {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Starter.class);
        CountryRepository repository = context.getBean(CountryRepository.class);
        RegionRepository regionRepository = context.getBean(RegionRepository.class);
        CityRepository cityRepository = context.getBean(CityRepository.class);

        CountryEntity country1 = new CountryEntity();
        country1.setName("Италия");
        repository.save(country1);

        RegionEntity region11 = new RegionEntity();
        region11.setName("Тоскана");
        region11.setCountry(country1);
        regionRepository.save(region11);

        CityEntity city111 = new CityEntity();
        city111.setName("Флоренция");
        city111.setRegion(region11);
        cityRepository.save(city111);

        CityEntity city112 = new CityEntity();
        city112.setName("Сиена");
        city112.setRegion(region11);
        cityRepository.save(city112);

        RegionEntity region12 = new RegionEntity();
        region12.setName("Пьемонт");
        region12.setCountry(country1);
        regionRepository.save(region12);

        CityEntity city121 = new CityEntity();
        city121.setName("Турин");
        city121.setRegion(region12);
        cityRepository.save(city121);

        CityEntity city122 = new CityEntity();
        city122.setName("Алессандрия");
        city122.setRegion(region12);
        cityRepository.save(city122);

        CountryEntity country2 = new CountryEntity();
        country2.setName("Франция");
        repository.save(country2);

        RegionEntity region21 = new RegionEntity();
        region21.setName("Аквитания");
        region21.setCountry(country2);
        regionRepository.save(region21);

        CityEntity city211 = new CityEntity();
        city211.setName("Бордо");
        city211.setRegion(region21);
        cityRepository.save(city211);

        CityEntity city212 = new CityEntity();
        city212.setName("Вильнав-д'Орнон");
        city212.setRegion(region21);
        cityRepository.save(city212);

        RegionEntity region22 = new RegionEntity();
        region22.setName("Иль-де-Франс");
        region22.setCountry(country2);
        regionRepository.save(region22);

        CityEntity city221 = new CityEntity();
        city221.setName("Париж");
        city221.setRegion(region22);
        cityRepository.save(city221);

        CityEntity city222 = new CityEntity();
        city222.setName("О-де-Сен");
        city222.setRegion(region22);
        cityRepository.save(city222);
        
        List<CountryEntity> countries = (List<CountryEntity>) repository.findAll();
        int k = 0;
        for (CountryEntity country : countries) {
            k++;
            System.out.print("Country " + k + ": ");
            System.out.println(country.getName());
            Set<RegionEntity> regions = country.getRegion();
            int j = 0;
            for (RegionEntity region : regions) {
                j++;
                System.out.print("\t" + "Region " + k + "." + j + ": ");
                System.out.println(region.getName());
                Set<CityEntity> cities = region.getCity();
                int i = 0;
                for (CityEntity city : cities) {
                    i++;
                    System.out.print("\t\t" + "City " + k + "." + j + "." + i + ": ");
                    System.out.println(city.getName());
                }
                System.out.println("------------------------");
            }
            System.out.println("==========================");
        }

        context.close();
    }
}