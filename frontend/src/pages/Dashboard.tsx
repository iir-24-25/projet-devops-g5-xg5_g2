import { Box, Typography, Button, Grid } from '@mui/material';
import { useAuth } from '../auth/AuthContext';
import { useNavigate } from 'react-router-dom';

export default function Dashboard() {
  const { role, username, logout } = useAuth();
  const navigate = useNavigate();

  return (
    <Box sx={{ p: 4 }}>
      <Box sx={{ display: 'flex', justifyContent: 'space-between', mb: 4 }}>
        <Typography variant="h4">
          Welcome, {username} ({role})
        </Typography>
        <Button variant="contained" onClick={logout}>
          Logout
        </Button>
      </Box>

      <Grid container spacing={3}>
        {role === 'responsable' && (
          <Grid>
            <Button 
              variant="contained" 
              fullWidth 
              onClick={() => navigate('/users')}
              sx={{ py: 3 }}
            >
              Manage Users
            </Button>
          </Grid>
        )}
        
        <Grid>
          <Button
            variant="contained"
            fullWidth
            onClick={() => navigate('/medicines')}
            sx={{ py: 3 }}
          >
            Manage Medicines
          </Button>
        </Grid>

        <Grid>
          <Button
            variant="contained"
            fullWidth
            onClick={() => navigate('/stock')}
            sx={{ py: 3 }}
          >
            Stock Movements
          </Button>
        </Grid>
      </Grid>
    </Box>
  );
}