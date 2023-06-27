"use client";
import Container from "../Container";
import { TbBeach } from "react-icons/tb";
import {
  GiIsland,
  GiWindmill,
  GiBoatFishing,
  GiCastle,
  GiForestCamp,
  GiCaveEntrance,
  GiCactus,
  GiBarn,
} from "react-icons/gi";
import { MdOutlineVilla } from "react-icons/md";
import { TbMountain, TbPool } from "react-icons/tb";
import { FaSkiing } from "react-icons/fa";
import { BsSnow } from "react-icons/bs";
import CategoryBox from "../CategoryBox";
import { usePathname, useSearchParams } from "next/navigation";
export const categories = [
  {
    label: "Beach",
    icon: TbBeach,
    description: "This propoerty is close to the beach",
  },
  {
    label: "Windmills",
    icon: GiWindmill,
    description: "This propoerty is close to the windmill",
  },
  {
    label: "Modern",
    icon: MdOutlineVilla,
    description: "This propoerty is close to the modern",
  },
  {
    label: "Countryside",
    icon: TbMountain,
    description: "This propoerty is in the countryside",
  },
  {
    label: "Pools",
    icon: TbPool,
    description: "This propoerty has a pool",
  },
  {
    label: "Island",
    icon: GiIsland,
    description: "This propoerty is on an island",
  },
  {
    label: "Lake",
    icon: GiBoatFishing,
    description: "This propoerty is close to a lake",
  },
  {
    label: "Skiing",
    icon: FaSkiing,
    description: "This propoerty has skiing activities",
  },
  {
    label: "Castle",
    icon: GiCastle,
    description: "This propoerty is in a castle",
  },
  {
    label: "Camping",
    icon: GiForestCamp,
    description: "This propoerty has camping activities",
  },
  {
    label: "Arctic",
    icon: BsSnow,
    description: "This propoerty has arctic activities",
  },
  {
    label: "Cave",
    icon: GiCaveEntrance,
    description: "This propoerty  is in a cave",
  },
  {
    label: "Desert",
    icon: GiCactus,
    description: "This propoerty has arctic activities",
  },
  {
    label: "Barn",
    icon: GiBarn,
    description: "This propoerty is in the barn",
  },
];

const Categories = () => {
  const params = useSearchParams();
  const category = params?.get("category");
  const pathname = usePathname();

  const isMainPage = pathname === "/";
  if (!isMainPage) {
    return null;
  }
  return (
    <Container>
      <div className="pt-4 flex flex-row items-center justify-between overflow-x-auto">
        {categories.map((item) => (
          <CategoryBox
            key={item.label}
            label={item.label}
            selected={category === item.label}
            icon={item.icon}
          />
        ))}
      </div>
    </Container>
  );
};

export default Categories;
