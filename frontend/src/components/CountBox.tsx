import React, { useEffect, useState } from "react";
import styled from "styled-components";
import formatMoney from "../util/formatMoney";

interface CountBoxProps {
  type: "price" | "token";
  size: number;
}

function CountBox({ type, size }: CountBoxProps) {
  useEffect(() => {
    setNowSize(size);
  }, [size]);
  const [nowSize, setNowSize] = useState(0);
  const updownSize = type === "price" ? 100 : 1;
  const unit = type ==="price" ? "원" : "토큰"
  return (
    <Container className="hana-bold">
      <p
        className="hana-regular"
        style={{ fontSize: 40, fontWeight: 300, cursor: "pointer" }}
        onClick={() => {
          if (nowSize > 0) setNowSize(nowSize - updownSize);
        }}
      >
        -
      </p>
      <p className="hana-bold">{formatMoney(nowSize)}{unit}</p>
      <p
        className="hana-regular"
        style={{ fontSize: 40, fontWeight: 300, cursor: "pointer" }}
        onClick={() => setNowSize(nowSize + updownSize)}
      >
        +
      </p>
    </Container>
  );
}

export default CountBox;

const Container = styled.div`
  display: flex;
  width: 90%;
  height: 70px;
  justify-content: space-around;
  align-items: center;
  border: 1px solid black;
  border-radius: 5px;
  font-size: 22px;
  font-weight: 500;
  user-select: none;
`;
