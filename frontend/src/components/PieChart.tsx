import React from "react";
import { ResponsivePie } from "@nivo/pie";

interface DataProps {
  id: string;
  label: string;
  value: number;
  color: string;
}

const data = [
  {
    id: "이승현",
    label: "이승현",
    value: 442,
    color: "hsl(104, 70%, 50%)",
  },
  {
    id: "신현창",
    label: "신현창",
    value: 588,
    color: "hsl(185, 70%, 50%)",
  },
  {
    id: "이현진",
    label: "이현진",
    value: 405,
    color: "hsl(297, 70%, 50%)",
  },
  {
    id: "최민길",
    label: "최민길",
    value: 87,
    color: "hsl(48, 70%, 50%)",
  },
  {
    id: "김성훈",
    label: "김성훈",
    value: 201,
    color: "hsl(206, 70%, 50%)",
  },
];

const PieChart = () => (
  <ResponsivePie
    data={data}
    margin={{ top: 10, right: 80, bottom: 80, left: -100 }}
    sortByValue={true}
    innerRadius={0.5}
    padAngle={0.7}
    activeOuterRadiusOffset={8}
    colors={{ scheme: "category10" }}
    borderWidth={1}
    borderColor={{
      from: "color",
      modifiers: [["darker", 0.2]],
    }}
    enableArcLinkLabels={false}
    arcLinkLabelsSkipAngle={10}
    arcLinkLabelsTextColor="#333333"
    arcLinkLabelsThickness={2}
    arcLinkLabelsColor={{ from: "color" }}
    arcLabelsRadiusOffset={0.45}
    arcLabelsTextColor={{
      from: "color",
      modifiers: [["darker", 2]],
    }}
    legends={[
      {
        anchor: "right",
        direction: "column",
        justify: false,
        translateX: 40,
        translateY: 0,
        itemWidth: 109,
        itemHeight: 20,
        itemsSpacing: 8,
        symbolSize: 12,
        itemDirection: "left-to-right",
      },
    ]}
  />
);

export default PieChart;
