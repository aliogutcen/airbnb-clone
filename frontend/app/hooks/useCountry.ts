import countries from "world-countries";

const formatCountries = countries.map((country) => ({
  value: country.cca2,
  label: country.name.common,
  flag: country.flag,
  latlng: country.latlng,
  region: country.region,
}));

const useCountry = () => {
  const getAll = () => formatCountries;

  const getByValue = (value: string) => {
    return formatCountries.find((item) => item.value === value);
  };

  return {
    getAll,
    getByValue,
  };
};
export default useCountry;
