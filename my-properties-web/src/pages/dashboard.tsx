import { useEffect, useState } from 'react';
import styles from '@/styles/Dashboard.module.css';
import Image from 'next/image';

export type User = {
  id: number;
  name: string;
  email: string;
  isVerify: number;
  properties?: UserProperties[];
};

export type UserProperties = {
  id: number;
  name: string;
  address: string;
  city: string;
};

export const mockUser: User[] = [
  {
    id: 1,
    name: 'Andy',
    email: 'andy.example@ff.com',
    isVerify: 0,
    properties: [
      {
        id: 0,
        name: 'string',
        address: 'string',
        city: 'string',
      },
    ],
  },
  {
    id: 2,
    name: 'Mandy',
    email: 'Mandy.example@ff.com',
    isVerify: 1,
    properties: [
      {
        id: 0,
        name: 'string',
        address: 'string',
        city: 'string',
      },
    ],
  },
];

const Dashboard: React.FC = () => {
  const [users, setUsers] = useState<User[]>([]);

  useEffect(() => {
    // Fetch user data from API
    fetch('http://localhost:8080/api/users')
      .then((response) => response.json())
      .then((data) => setUsers(data));
  }, []);

  return (
    <div className={styles.container}>
      <h1 className={styles.title}>User Dashboard</h1>
      <div className={styles.cardContainer}>
        {users.map((user) => (
          <div key={user.id} className={styles.card}>
            <h2>{user.name}</h2>
            <p>{user.email}</p>
            {user.isVerify ? (
              <p>
                <Image
                  src="/checkmark.png"
                  alt={'yes'}
                  width={20}
                  height={20}
                ></Image>
              </p>
            ) : (
              <div>
                <p>
                  <Image
                    src="/close.png"
                    alt={'no'}
                    width={20}
                    height={20}
                  ></Image>
                </p>
              </div>
            )}
            <a href={`/users/${user.id}`} className={styles.link}>
              View Property Details
            </a>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Dashboard;
