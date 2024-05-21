import React from "react";
import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import OnBoard from "./pages/OnBoard";
import Main from "./pages/Main";
import RegistProspect from "./pages/RegistProspect";
import ProList from "./pages/ProList";
import ProDetail from "./pages/ProDetail";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" Component={OnBoard} />
        <Route path="/main" Component={Main} />
        <Route path="/registProspect" Component={RegistProspect} />
        <Route path="/proList" Component={ProList} />
        <Route path="/proDetail/:id" Component={ProDetail} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
