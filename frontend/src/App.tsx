import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { AuthProvider } from './auth/AuthContext';
import ProtectedRoute from './components/ProtectedRoute';
import Login from './pages/Login';
import Register from './pages/Register';
import UserManagement from './pages/UserManagement';
import Unauthorized from './pages/Unauthorized';
import Dashboard from './pages/Dashboard';
import Navbar from './components/Navbar';

export default function App() {
  return (
    <AuthProvider>
      <BrowserRouter>
      <Navbar />
        <Routes>
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />
          
          <Route element={<ProtectedRoute allowedRoles={['pharmacien', 'responsable']} />}>
            <Route path="/" element={<Dashboard />} />
          </Route>

          <Route element={<ProtectedRoute allowedRoles={['responsable']} />}>
            <Route path="/users" element={<UserManagement />} />
          </Route>

          <Route path="/unauthorized" element={<Unauthorized />} />
        </Routes>
      </BrowserRouter>
    </AuthProvider>
  );
}