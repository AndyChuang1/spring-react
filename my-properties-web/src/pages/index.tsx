
import styles from "@/styles/Home.module.css";
import Link from "next/link";



const Home: React.FC = () => {
  return (
    <div className={styles.container}>
      <div className={styles.welcomeBox}>
        <h1 className={styles.welcomeText}>
          <Link href="/dashboard">
            Welcome to My-Properties
          </Link>
        </h1>
      </div>
    </div>
  );
}

export default Home;