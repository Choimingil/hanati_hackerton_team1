import React from "react";
import styled from "styled-components";

interface ProUserBoxProps {
  id: number;
  imgUrl: string;
  name: string;
  number?: number;
  price: number;
  position: string;
  onClick?: (event: React.MouseEvent<HTMLDivElement>) => void;
}

function ProUserBox({ id, imgUrl, name, number, price, position, onClick }: ProUserBoxProps) {
  const calcUpDown = (price: number) => {
    if (price > 0) {
      return true
    } else {
      return false;
    }
  };

  const checkPrice = (price: number) => {
    if (price < 0) {
      return price * -1
    } else {
      return price;
    }
  }

  const upDownIcon = (price: number) => {
    if (price < 0) {
      return '▼'
    } else {
      return '▲'
    }
  }

  return (
    <ProUserDiv id={String(id)} onClick={onClick}>
      <ProUserImage src={imgUrl} alt="pro_image" />
      <NameBox className="hana-regular">
        <div>{number}</div> {position} {name}
      </NameBox>
      <PriceBox className="hana-bold">
        <div className={calcUpDown(price) ? "price red" : "price blue"}>{checkPrice(price)}</div>
        <div className={calcUpDown(price) ? "up-down red" : "up-down blue"}>
          <p>{upDownIcon(price)}2.42</p>&nbsp;&nbsp;&nbsp;&nbsp;
          <p>3.52%</p>
        </div>
      </PriceBox>
    </ProUserDiv>
  );
}

export default ProUserBox;

export const ProUserDiv = styled.div`
  width: 105px;
  height: 245px;
  border-radius: 10px;
  cursor: pointer;
  font-size: 0;
  border: 1px solid gray;
`;

export const ProUserImage = styled.img`
  width: 105px;
  height: 150px;
  border-radius: 10px 10px 0 0;
`;

const PriceBox = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 70px;
  border-radius: 0px 0px 10px 10px;
  gap: 0;
  .price {
    font-size: 18px;
  }
  .up-down {
    display: flex;
    font-size: 10px;
    justify-content: space-between;
  }
  .blue {
    color: #2d78fa;
  }
  .red {
    color: #eb1202;
  }
`;
export const NameBox = styled.div`
  width: 105px;
  height: 30px;
  display: flex;
  font-size: 14px;
  justify-content: flex-start;
  gap: 7px;
  border-bottom: 1px solid gray;
  align-items: center;
  background-color: #008476;
  color: white;
  font-size: 12px;
  div {
    width: 28px;
    height: 100%;
    background-color: #972941;
    text-align: center;
    display: flex;
    color: white;
    justify-content: center;
    align-items: center;
  }
`;
