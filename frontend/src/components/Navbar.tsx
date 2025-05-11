import { Link } from 'react-router-dom';
import { useAuth } from '../auth/AuthContext';
import { AppBar, Toolbar, Button, Typography } from '@mui/material';

export default function Navbar() {
  const { role, logout } = useAuth();

  return (
    <AppBar position="static">
      <Toolbar>
        <Typography variant="h6" sx={{ flexGrow: 1 }}>
          Pharmacy Stock System
        </Typography>
        
        {role === 'responsable' && (
          <Button color="inherit" component={Link} to="/users">
            Users
          </Button>
        )}
        
        <Button color="inherit" component={Link} to="/register">
          Register
        </Button>
        <Button color="inherit" component={Link} to="/medicines">
          Medicines
        </Button>
        <Button color="inherit" component={Link} to="/stock">
          Stock
        </Button>
        <Button color="inherit" onClick={logout}>
          Logout
        </Button>
      </Toolbar>
    </AppBar>
  );
}

// Empty export to satisfy isolatedModules
export {};