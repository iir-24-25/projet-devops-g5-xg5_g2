import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { register } from '../api/auth';
import { 
  Button, TextField, Container, Box, MenuItem, Select, InputLabel, 
  FormControl, CircularProgress, Alert 
} from '@mui/material';

export default function Register() {
  const [formData, setFormData] = useState({
    username: '',
    password: '',
    email: '',
    role: 'pharmacien'
  });
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState('');
  const [success, setSuccess] = useState(false);
  const navigate = useNavigate();

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    setLoading(true);
    setError('');
    
    try {
      await register(formData);
      setSuccess(true);
      setTimeout(() => navigate('/login'), 2000);
    } catch (error) {
      setError('Registration failed. Username or email might be taken.');
      console.error('Registration error:', error);
    } finally {
      setLoading(false);
    }
  };

  return (
    <Container maxWidth="xs">
      <Box component="form" onSubmit={handleSubmit} sx={{ mt: 8 }}>
        {success && (
          <Alert severity="success" sx={{ mb: 2 }}>
            Registration successful! Redirecting to login...
          </Alert>
        )}
        {error && <Alert severity="error" sx={{ mb: 2 }}>{error}</Alert>}

        <TextField
          label="Username"
          fullWidth
          margin="normal"
          required
          value={formData.username}
          onChange={(e) => setFormData({ ...formData, username: e.target.value })}
        />
        <TextField
          label="Password"
          type="password"
          fullWidth
          margin="normal"
          required
          value={formData.password}
          onChange={(e) => setFormData({ ...formData, password: e.target.value })}
        />
        <TextField
          label="Email"
          type="email"
          fullWidth
          margin="normal"
          required
          value={formData.email}
          onChange={(e) => setFormData({ ...formData, email: e.target.value })}
        />
        <FormControl fullWidth margin="normal">
          <InputLabel>Role</InputLabel>
          <Select
            value={formData.role}
            label="Role"
            onChange={(e) => setFormData({ ...formData, role: e.target.value })}
          >
            <MenuItem value="pharmacien">Pharmacien</MenuItem>
            <MenuItem value="responsable">Responsable</MenuItem>
          </Select>
        </FormControl>
        <Button 
          type="submit" 
          fullWidth 
          variant="contained" 
          sx={{ mt: 3 }}
          disabled={loading}
        >
          {loading ? <CircularProgress size={24} /> : 'Register'}
        </Button>
      </Box>
    </Container>
  );
}