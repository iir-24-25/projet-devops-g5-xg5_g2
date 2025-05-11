import api from './client';

export const login = async (username: string, password: string) => {
  const response = await api.post('/auth/login', { username, password });
  return response.data;
};

export const register = async (userData: {
  username: string;
  password: string;
  email: string;
  role: string;
}) => {
  const response = await api.post('/auth/register', userData);
  return response.data;
};