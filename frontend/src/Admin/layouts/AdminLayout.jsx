import React from "react";
import { Outlet } from 'react-router-dom';
import Sidebar from "../components/Sidebar/Sidebar";
// import Navbar from "../components/Navbar/Navbar";
import Navbar from "../../components/navbar/navbar"
import 'bootstrap/dist/css/bootstrap.min.css';

const AdminLayout = () => {
  return (
    <div className="container-fluid">
      {/* <Navbar /> */}
      <Navbar/>
      <hr />
      <div className="row">
        <div className="d-flex">
          <Sidebar />
        <div className="flex-grow-1 p-3">
          <Outlet />
        </div>
        </div>
      </div>
    </div>
  );
};

export default AdminLayout;


