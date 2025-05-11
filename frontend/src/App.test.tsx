import React from 'react';
import { render, screen } from '@testing-library/react';
import App from './App';
import { MemoryRouter } from 'react-router-dom'; // Need to wrap in this element so the test passes

test('renders app component', () => {
  render(
    <MemoryRouter> {/* Wrap App with MemoryRouter */}
      <App />
    </MemoryRouter>
  );
  
  // Simple test
  const loginElement = screen.getByText(/login/i);
  expect(loginElement).toBeInTheDocument();
});