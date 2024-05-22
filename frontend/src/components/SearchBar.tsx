import React from "react";
import styled from "styled-components";
import Search_icon from "../f_images/search_icon.png";

function SearchBar() {
  return (
    <Wrapper>
      <SearchBox placeholder="검색어를 입력하세요"></SearchBox>
      <SearchIcon src={Search_icon} />
    </Wrapper>
  );
}

export default SearchBar;

const Wrapper = styled.div`
  width: 100%;
  height: 100px;
  margin: 0 auto;
  background-color: white;
  display: flex;
  align-items: center;
  justify-content: center;
  position: relative;
`;

const SearchBox = styled.input`
  width: 373px;
  height: 34px;
  margin: 0 auto;
  border: 1px solid #008476;
  border-radius: 20px;
  padding-left: 10px;
`;

const SearchIcon = styled.img`
  position: absolute;
  right: 40px;
  cursor: pointer;
`;
