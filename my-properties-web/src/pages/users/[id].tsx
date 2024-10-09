import { useRouter } from 'next/router';
import { useEffect, useState } from 'react';
import { User } from '../dashboard';
import styles from '@/styles/UserDetail.module.css';

export type UpdateUser = {
  name?: string;
  email?: string;
  isVerify?: number;
};
const UserDetails: React.FC = () => {
  const router = useRouter();
  const { id } = router.query;
  const [user, setUser] = useState<User | null>();
  const [isEditing, setIsEditing] = useState(false);
  const [updatedUser, setUpdatedUser] = useState<UpdateUser>({});

  useEffect(() => {
    if (id) {
      // Fetch single user data
      fetch(`http://localhost:8080/api/users/${id}`)
        .then((response) => response.json())
        .then((data: User) => {
          setUser(data);
          setUpdatedUser({
            name: data.name,
            email: data.email,
            isVerify: data.isVerify,
          });
        });
    }
  }, [id]);

  const handleEdit = () => {
    setIsEditing(!isEditing);
  };

  const handleSave = async () => {
    const response = await fetch(`http://localhost:8080/api/users/${id}`, {
      method: 'PATCH',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(updatedUser),
    });

    if (response.ok) {
      const user: User = await response.json();
      setUser(user);
      //   setUser(response.json() as User);
      setIsEditing(false); // Exit edit mode
    }
  };

  if (!user) return <p>Loading...</p>;

  return (
    <div className={styles.container}>
      <h1 className={styles.title}>User Property Details</h1>
      {isEditing ? (
        <div className={styles.form}>
          <label>
            Name:
            <input
              value={updatedUser.name}
              onChange={(e) =>
                setUpdatedUser({ ...updatedUser, name: e.target.value })
              }
              className={styles.input}
            />
          </label>
          <label>
            Email:
            <input
              value={updatedUser.email}
              onChange={(e) =>
                setUpdatedUser({ ...updatedUser, email: e.target.value })
              }
              className={styles.input}
            />
          </label>

          <button onClick={handleSave} className={styles.saveButton}>
            Save
          </button>
        </div>
      ) : (
        <div className={styles.details}>
          <p>Id: {user.id}</p>
          <p>Name: {user.name}</p>
          <p>Email: {user.email}</p>
        </div>
      )}
      <button onClick={handleEdit} className={styles.editButton}>
        {isEditing ? 'Cancel' : 'Edit'}
      </button>
    </div>
  );
};

export default UserDetails;
