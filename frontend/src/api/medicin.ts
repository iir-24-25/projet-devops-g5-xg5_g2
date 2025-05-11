import api from './client';

export interface Medicine {
  id: number;
  name: string;
  quantity: number;
  expirationDate: string;
}

export const getMedicines = async () => {
  const response = await api.get('/medicins');
  return response.data;
};

export const deleteMedicine = async (id: number) => {
  await api.delete(`/medicins/${id}`);
};

export const createMedicine = async (medicine: Omit<Medicine, 'id'>) => {
  const response = await api.post('/medicins', medicine);
  return response.data;
};

// Empty export to satisfy isolatedModules
export {};