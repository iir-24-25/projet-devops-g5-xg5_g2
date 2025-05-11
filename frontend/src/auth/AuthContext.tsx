import { createContext, useContext, useEffect, useState } from 'react';

interface AuthContextType {
  role: string | null;
  username: string | null;
  login: (role: string, username: string) => void;
  logout: () => void;
}

const AuthContext = createContext<AuthContextType>(null!);

export function AuthProvider({ children }: { children: React.ReactNode }) {
  const [role, setRole] = useState<string | null>(null);
  const [username, setUsername] = useState<string | null>(null);

  const login = (newRole: string, newUsername: string) => {
    setRole(newRole);
    setUsername(newUsername);
  };

  const logout = () => {
    localStorage.removeItem('token');
    setRole(null);
    setUsername(null);
  };

  useEffect(() => {
    const token = localStorage.getItem('token');
    if (token) {
      // Decode JWT to get role and username
      try {

        const payload = JSON.parse(atob(token.split('.')[1]));
        setRole(payload.role); // Make sure your JWT includes this claim
        setUsername(payload.sub); // Assuming username is in the subject

      } catch (error) {
        console.error('Error decoding token:', error);
        logout();
      }
    }
  }, [logout]);

  return (
    <AuthContext.Provider value={{ role, username, login, logout }}>
      {children}
    </AuthContext.Provider>
  );
}

export function useAuth() {
  return useContext(AuthContext);
}