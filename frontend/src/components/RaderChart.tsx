import React, { useEffect, useRef } from "react";
import ApexCharts from "apexcharts";
import styled from "styled-components";

const RadarChart = () => {
  const chartRef = useRef(null);

  useEffect(() => {
    const chartOptions = {
      chart: {
        type: "radar",
        width: "270px",
        height: "250px",
        toolbar: {
          show: false,
        },
        animations: {
          speed: 1200,
        },
      },
      title: {
        text: "선수 능력치",
        align: "center",
        style: {
          fontSize: "16px",
          fontFamily: "hana-bold",
          alignText: "center",
        },
      },
      xaxis: {
        categories: ["Speed", "Shooting", "Passing", "Dribbling", "Defense", "Physical"],
        labels: {
          style: {
            fontSize: "12px",
            fontWeight: "bold",
          },
        },
      },
      yaxis: {
        show: false,
      },
      colors: ["#008476"],
      series: [
        {
          name: "Player 1",
          data: [65, 59, 90, 81, 56, 55],
        },
      ],
    };

    const chart = new ApexCharts(chartRef.current, chartOptions);
    chart.render();

    return () => {
      chart.destroy();
    };
  }, []);

  return <div ref={chartRef} />;
};

export default RadarChart;
