import React from "react";
import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import OnBoard from "./pages/OnBoard";
import Main from "./pages/Main";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" Component={OnBoard} />
        <Route path="/main" Component={Main} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
